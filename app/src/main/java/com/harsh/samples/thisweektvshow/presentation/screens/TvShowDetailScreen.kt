package com.harsh.samples.thisweektvshow.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.harsh.samples.thisweektvshow.domain.model.TvShow
import com.harsh.samples.thisweektvshow.domain.model.TvShowSeason
import com.harsh.samples.thisweektvshow.presentation.composeables.SingleSeason

@Composable
fun TvShowDetailScreen(detailedTvShow: TvShow) {
    Column {
        AsyncImage(
            model = detailedTvShow.backdropUrl,
            contentDescription = "cover image"
        )
        
        Column(Modifier.padding(16.dp)) {
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Genres: ", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = detailedTvShow.genres.toString())
            }
            
            Spacer(modifier = Modifier.size(6.dp))
            Text(text = "Overview", style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.size(2.dp))
            Text(text = detailedTvShow.overview, textAlign = TextAlign.Justify)

            Spacer(modifier = Modifier.size(6.dp))
            Text(text = "List of seasons", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.size(2.dp))
            LazyColumn {
                items(detailedTvShow.seasons) {tvShowSeason ->
                    SingleSeason(season = tvShowSeason)
                    Spacer(modifier = Modifier.size(4.dp))
                }
            }

        }
    }
}

//TODO: Make ui better!

@Preview
@Composable
fun PreviewTvShowDetailScreen() {
    val gameOfThronesShow = TvShow(
        1,
        "Game of Thrones",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
        "https://image.tmdb.org/t/p/w500/1XS1oqL89opfnbLl8WnZY1O1uJx.jpg",
        "https://image.tmdb.org/t/p/w1280/rIe3PnM6S7IBUmvNwDkBMX0i9EZ.jpg",
        8.4f,
        listOf("Drama", "Action & Adventure"),
        listOf(
            TvShowSeason(1, "Season 1", 10, 1, 8.3f),
            TvShowSeason(2, "Season 2", 10, 2, 8.3f),
            TvShowSeason(3, "Season 3", 10, 3, 8.3f),
            TvShowSeason(4, "Season 4", 10, 4, 8.3f),
            TvShowSeason(5, "Season 5", 10, 5, 8.3f),
            TvShowSeason(6, "Season 6", 10, 6, 8.3f),
            TvShowSeason(7, "Season 7", 10, 7, 8.3f),
            TvShowSeason(8, "Season 8", 10, 8, 8.3f),
            TvShowSeason(9, "Season 9", 10, 9, 8.3f),
            TvShowSeason(10, "Season 10", 10, 10, 8.3f),
        )
    )

    TvShowDetailScreen(gameOfThronesShow)
}