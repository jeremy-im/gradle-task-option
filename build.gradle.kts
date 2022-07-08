
open class TaskWithOption : DefaultTask() {
    @Input @Option(description="simple example")
    var flag = false
}

tasks.register("doit", TaskWithOption::class) {
    extra.set("flagWas", flag)
    doFirst {
        val flagWas: Boolean by extra
        if (flag != flagWas)
            throw GradleException("flag was $flagWas at config, but is now $flag")
    }
}

