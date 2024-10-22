package ru.normno.myimagecompression

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import ru.normno.myimagecompression.ui.theme.MyImageCompressionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyImageCompressionTheme {
                PhotoPickerScreen(
                    imageCompressor = remember {
                        ImageCompressor(applicationContext)
                    },
                    fileManager = remember {
                        FileManager(applicationContext)
                    }
                )
            }
        }
    }
}