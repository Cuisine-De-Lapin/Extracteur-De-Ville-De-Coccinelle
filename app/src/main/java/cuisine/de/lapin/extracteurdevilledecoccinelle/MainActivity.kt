package cuisine.de.lapin.extracteurdevilledecoccinelle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cuisine.de.lapin.extracteurdevilledecoccinelle.ui.theme.ExtracteurDeVilleDeCoccinelleTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.net.URI


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val tweetViewModel: TweetViewModel by viewModels()

    private val fileExplorerResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            Log.i("fileResult", "${result.data}")
            result.data?.clipData?.getItemAt(0)?.uri?.let {
                val file = File(it.path)
                Log.i("fileResult", "${file.isFile} ${file.length()} ${file.path}")
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtracteurDeVilleDeCoccinelleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(
                        modifier = Modifier.clickable {
//                            tweetViewModel.testTweet()



                            val intent = Intent(Intent.ACTION_GET_CONTENT)
                            intent.type = "image/png"
                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                            fileExplorerResultLauncher.launch(intent)

                        },
                        text = "Click to tweet"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExtracteurDeVilleDeCoccinelleTheme {
        Greeting("Android")
    }
}