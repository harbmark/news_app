package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsList = listOf(
            NewsItem(
                "Android 15 Beta Released",
                "Experts encourage digital detox and balanced screen time for better well-being.",
                R.drawable.news1
            ),
            NewsItem(
                "Mental Health Awareness Week",
                "Experts encourage digital detox and balanced screen time for better well-being.",
                R.drawable.news2
            ),
            NewsItem(
                "International Travel Rebounds",
                "Air travel increases as more countries ease entry restrictions worldwide.",
                R.drawable.news3
            ),
            NewsItem(
                "New AI Search Tool Launched",
                "A powerful document search engine helps users find information instantly.",
                R.drawable.news4
            ),
            NewsItem(
                "Biometric Security Upgrade",
                "New fingerprint authentication system improves mobile device protection.",
                R.drawable.news5
            )
        )

        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsScreen(newsList)
                }
            }
        }
    }
}

@Composable
fun NewsScreen(items: List<NewsItem>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Title
        item {
            Text(
                text = "News",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        // News items
        items(items) { item ->
            NewsRow(item)
            Divider(modifier = Modifier.padding(vertical = 10.dp))
        }

        // 👇 This fills the remaining screen space
        item {
            Spacer(modifier = Modifier.fillParentMaxHeight())
        }
    }
}

@Composable
fun NewsRow(item: NewsItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = "news image",
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}