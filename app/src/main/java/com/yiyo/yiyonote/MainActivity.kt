package com.yiyo.yiyonote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yiyo.yiyonote.screens.NoteScreen
import com.yiyo.yiyonote.screens.NoteViewModel
import com.yiyo.yiyonote.ui.theme.YiyoNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YiyoNoteTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    NoteScreen(
        notes = noteViewModel.noteList.collectAsState().value,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.removeNote(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    YiyoNoteTheme {
        NoteScreen(
            notes = emptyList(),
            onAddNote = {},
            onRemoveNote = {}
        )
    }
}