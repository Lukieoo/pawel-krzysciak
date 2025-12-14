package com.pawkrzysciak.portfolio.section.technologies

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.fakes.hobbies
import com.pawkrzysciak.portfolio.fakes.technologies
import com.pawkrzysciak.portfolio.fakes.tools
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import com.pawkrzysciak.portfolio.theme.isMobile
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.draw

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechnologiesAndToolsSection(modifier: Modifier) {
    FlowRow(
        modifier = modifier.background(color = Color.White).padding(vertical = 40.dp),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(min = 100.dp, max = 850.dp)
                .fillMaxWidth()
                .padding(horizontal = GetLayoutPadding())
        ) {
            Text(
                text = CurrentStrings.strings.technologiesTitle,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = CurrentStrings.strings.technologiesDescription,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = CurrentStrings.strings.technologiesLabel,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                technologies.forEach { tech ->
                    SuggestionChip(onClick = {}, label = { Text(tech) })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = CurrentStrings.strings.toolsLabel,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                tools.forEach { tool ->
                    SuggestionChip(onClick = {}, label = { Text(tool) })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = CurrentStrings.strings.hobbiesLabel,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                hobbies.forEach { hobby ->
                    SuggestionChip(onClick = {}, label = { Text(hobby) })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
        if (isMobile.not()) {
            Image(
                painter = painterResource(Res.drawable.draw),
                contentDescription = null,
                modifier = Modifier.weight(1f).size(600.dp),
            )
        }
    }
}
