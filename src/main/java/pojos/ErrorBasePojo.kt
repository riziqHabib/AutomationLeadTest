package pojos

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
data class ErrorBasePojo(val error: ErrorCodePojo);
data class ErrorCodePojo (val message:String,val code:Int);


