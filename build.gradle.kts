
open class TaskWithOption : DefaultTask() {
    @Input @Option(description="simple example")
    var flag = false
}

tasks.register("doit", TaskWithOption::class) {
    val flagWas = flag
    doFirst {
        check(flagWas == flag) { "flag was $flagWas, but is now $flag" }
    }
}

