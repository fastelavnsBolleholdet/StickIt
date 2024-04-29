import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerState {
    private var startTime: Long = 0
    private var stopTime: Long = 0
    private var _elapsedTime = mutableStateOf(0L)
    val elapsedTime: Long get() = _elapsedTime.value
    var isRunning by mutableStateOf(false)

    fun start() {
        startTime = System.currentTimeMillis() - (_elapsedTime.value - stopTime)
        isRunning = true
        CoroutineScope(Dispatchers.Main).launch {
            while (isRunning) {
                val currentTime = System.currentTimeMillis()
                _elapsedTime.value = currentTime - startTime
                delay(100)
            }
        }
    }

    fun stop() {
        stopTime = _elapsedTime.value
        isRunning = false
    }
}
