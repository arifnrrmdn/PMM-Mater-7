package unikom.arif.materi7

data class ReadModel (
    val result: List<Data>
) {
        data class Data (val id: String?, val name: String?, val number: String?)
}