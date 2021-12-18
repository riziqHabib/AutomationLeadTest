package pojos

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */

data class JokesPojo(val language:String,val data:String,val description:String,val joke:JokeDataPojo,val category:String,val background:String);
data class JokeDataPojo(val racial:String?,val title:String?,val date:String?,val length:Int?,val clean:Int?,val id:String,val text:String);
data class JokePojosContent(val jokes:Array<JokesPojo>,val copyright:String ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JokePojosContent

        if (!jokes.contentEquals(other.jokes)) return false
        if (copyright != other.copyright) return false

        return true
    }

    override fun hashCode(): Int {
        var result = jokes.contentHashCode()
        result = 31 * result + copyright.hashCode()
        return result
    }
};

data class JokePojo(val success:Total,val contents:JokePojosContent);