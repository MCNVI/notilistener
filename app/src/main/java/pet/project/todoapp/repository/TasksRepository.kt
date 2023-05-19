package pet.project.todoapp.repository

import pet.project.todoapp.api.TasksApi
import pet.project.todoapp.common.RequestResult
import pet.project.todoapp.model.TodoListState
import javax.inject.Inject

interface TasksRepository {
    suspend fun getTasks(): RequestResult<List<TodoListState.Task>>
}

class TasksRepositoryImpl @Inject constructor(
    private val api: TasksApi
): TasksRepository {

    override suspend fun getTasks(): RequestResult<List<TodoListState.Task>> {
        return try {
            RequestResult.Success(
                data = api.getTasks().map { it.toTask() }
            )
        } catch(e: Exception) {
            e.printStackTrace()
            RequestResult.Error(e.message ?: "An unknown error occurred.")
        }
    }
}