package pet.project.todoapp.model

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pet.project.todoapp.common.RequestResult
import pet.project.todoapp.repository.TasksRepository
import javax.inject.Inject

data class TodoListState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val tasks: List<Task> = emptyList()
) {
    data class Task(
        val title: String,
        val description: String
    )
}

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TasksRepository
): ViewModel() {

    var state by mutableStateOf(TodoListState())
        private set

    fun loadTasks() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                tasks = emptyList()
            )
            when (val requestResult = repository.getTasks()) {
                is RequestResult.Success -> {
                    state = state.copy(
                        tasks = requestResult.data ?: emptyList(), //TODO: do better
                        isLoading = false,
                        error = requestResult.message
                    )
                }

                is RequestResult.Error -> {
                    state = state.copy(
                        tasks = emptyList(),
                        isLoading = false,
                        error = requestResult.message
                    )
                }
            }
        }
    }
}