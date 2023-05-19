package pet.project.todoapp.dto

import pet.project.todoapp.model.TodoListState

data class TaskDto(
    val title: String,
    val description: String
) {
    suspend fun toTask(): TodoListState.Task = TodoListState.Task(
        title = title,
        description = description
    )
}