package ru.normno.myimagecompression

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FileManager(
    private val context: Context,
) {
    suspend fun saveImage(
        contentUri: Uri,
        fileName: String,
    ) {
        withContext(Dispatchers.IO) {
            context
                .contentResolver
                .openInputStream(contentUri)
                ?.use { iputStream ->
                    context
                        .openFileOutput(fileName, Context.MODE_PRIVATE)
                        .use { outputStream ->
                            iputStream.copyTo(outputStream)
                        }
                }
        }
    }

    suspend fun saveImage(
        bytes: ByteArray,
        fileName: String,
    ) {
        withContext(Dispatchers.IO) {
            context
                .openFileOutput(fileName, Context.MODE_PRIVATE)
                .use { outputStream ->
                    outputStream.write(bytes)
                }
        }
    }
}