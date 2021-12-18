package pojos

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */

data class JokeCategoryPojos (val language:String,val name:String,val background:String,val description:String);
data class ContentsPojo(val categories:Array<JokeCategoryPojos>,val copyright:String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ContentsPojo

        if (!categories.contentEquals(other.categories)) return false
        if (copyright != other.copyright) return false

        return true
    }

    override fun hashCode(): Int {
        var result = categories.contentHashCode()
        result = 31 * result + copyright.hashCode()
        return result
    }
};
data class Total(val total:Int);
data class CategoriesPojo(val success:Total,val contents:ContentsPojo);
