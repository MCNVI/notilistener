package pet.project.todoapp.api

import pet.project.todoapp.dto.TaskDto
import retrofit2.http.GET


interface TasksApi {

    @GET("/api/tasks")
    suspend fun getTasks(): List<TaskDto>

}