package com.example.bookshelf.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshelf.data.Book
import com.example.bookshelf.ui.BooksUiState

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onBookClicked: (Book) -> Unit
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreens(modifier)
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = modifier,
            onBookClicked
        )
        is BooksUiState.Error -> ErrorScreens(retryAction = retryAction, modifier)
    }
}