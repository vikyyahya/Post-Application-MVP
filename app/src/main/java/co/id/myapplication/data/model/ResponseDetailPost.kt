package co.id.myapplication.data.model

data class ResponseDetailPost(
	val comments: List<CommentsItem?>? = null,
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val userId: Int? = null
)

data class CommentsItem(
	val name: String? = null,
	val postId: Int? = null,
	val id: Int? = null,
	val body: String? = null,
	val email: String? = null
)

