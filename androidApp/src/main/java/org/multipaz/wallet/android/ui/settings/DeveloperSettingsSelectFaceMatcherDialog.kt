package org.multipaz.wallet.android.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.multipaz.wallet.android.R
import org.multipaz.wallet.android.settings.SettingsModel

@Composable
fun DeveloperSettingsSelectFaceMatcherDialog(
    settingsModel: SettingsModel,
    choices: List<String>,
    onSelected: (selectedMatcher: String) -> Unit,
    onDismissed: () -> Unit
) {
    val currentChoice = settingsModel.presentmentFaceMatcher.collectAsState().value

    AlertDialog(
        onDismissRequest = onDismissed,
        confirmButton = {
            TextButton(onClick = onDismissed) {
                Text(text = stringResource(R.string.dev_settings_face_matcher_dialog_close))
            }
        },
        title = {
            Text(text = stringResource(R.string.dev_settings_face_matcher_dialog_title))
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                choices.forEach { choice ->
                    val blurbResId = when (choice) {
                        "MobileFaceNet" -> R.string.dev_settings_face_matcher_mobilefacenet_blurb
                        "MobileFaceNet (debug)" -> R.string.dev_settings_face_matcher_mobilefacenet_debug_blurb
                        "None" -> R.string.dev_settings_face_matcher_none_blurb
                        else -> null
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onSelected(choice)
                            }
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        RadioButton(
                            selected = (choice == currentChoice),
                            onClick = null,
                            modifier = Modifier.padding(top = 2.dp, end = 12.dp)
                        )
                        Column {
                            Text(
                                text = choice,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (blurbResId != null) {
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = stringResource(blurbResId),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}
