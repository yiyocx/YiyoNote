package com.yiyo.yiyonote.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID): String = uuid.toString()

    @TypeConverter
    fun toUUID(id: String?): UUID? = UUID.fromString(id)
}
