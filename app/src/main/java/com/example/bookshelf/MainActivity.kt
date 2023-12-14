package com.example.bookshelf

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.core.content.ContextCompat
import com.example.bookshelf.ui.BooksApp
import com.example.bookshelf.ui.theme.BookShelfTheme

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookShelfTheme {
               BooksApp(
                   onBookClicked = {
                       ContextCompat.startActivity(
                           this,
                           Intent(Intent.ACTION_VIEW, Uri.parse(it.previewLink)),
                           null
                       )
                   }
               )
            }
        }
    }
}