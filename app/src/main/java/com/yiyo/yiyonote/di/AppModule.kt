package com.yiyo.yiyonote.di

import android.content.Context
import androidx.room.Room
import com.yiyo.yiyonote.data.NoteDatabase
import com.yiyo.yiyonote.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(notesDatabase: NoteDatabase): NoteDatabaseDao = notesDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            name = "notes_db"
        )
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()
    }
}
