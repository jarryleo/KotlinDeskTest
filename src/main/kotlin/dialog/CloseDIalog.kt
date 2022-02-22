import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import theme.Purple200

/**
 * 退出程序确认弹框
 */

@Composable
fun AskToCloseDialog(
    isOpen: MutableState<Boolean>,
    isAskingToClose: MutableState<Boolean>,
) {
    Dialog(
        onCloseRequest = { isAskingToClose.value = false },
        title = "退出",
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("确认退出app吗？")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { isOpen.value = false }
                ) {
                    Text("Yes")
                }
                Button(
                    colors = ButtonDefaults.buttonColors(Purple200, Color.White),
                    onClick = { isAskingToClose.value = false }
                ) {
                    Text("No")
                }
            }
        }
    }
}