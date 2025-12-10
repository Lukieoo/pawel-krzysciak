package com.pawkrzysciak.portfolio.section.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.fakes.hobbies
import com.pawkrzysciak.portfolio.fakes.technologies
import com.pawkrzysciak.portfolio.fakes.tools
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechnologiesAndToolsSection() {
    Column(
        modifier = Modifier
            .widthIn(min = 100.dp, max = 850.dp)
            .fillMaxWidth()
            .padding(horizontal = GetLayoutPadding())
    ) {
        Text(
            text = "Technologie i narzędzia",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Podczas pracy komercyjnej oraz realizując własne projekty "
                    + "miałem okazję korzystać z różnych technologii, bibliotek i narzędzi "
                    + "związanych z ekosystemem Androida oraz backendem. "
                    + "\nPoniżej przedstawiam niektóre z technologie, programy i narzędzia, "
                    + "z którymi miałem styczność.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Technologie:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            technologies.forEach { tech ->
                SuggestionChip(onClick = {}, label = { Text(tech) })
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Narzędzia i programy:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            tools.forEach { tool ->
                SuggestionChip(onClick = {}, label = { Text(tool) })
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Hobbystycznie:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            hobbies.forEach { hobby ->
                SuggestionChip(onClick = {}, label = { Text(hobby) })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
