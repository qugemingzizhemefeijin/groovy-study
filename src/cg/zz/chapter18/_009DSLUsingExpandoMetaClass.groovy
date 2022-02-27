package cg.zz.chapter18

// 分类只能应用在use块内，而且其效果被限制在了作用域内。如果希望方法注入在整个应用内都有效果，可以使用ExpandoMetaClass来代替分类。

Integer.metaClass {
    getDays = { ->
        delegate
    }

    getAgo = { ->
        def date = Calendar.instance
        date.add(Calendar.DAY_OF_MONTH, -delegate)
        date
    }

}

Calendar.metaClass.at = { Map time ->
    def hour = 0
    def minute = 0
    time.each { key, value ->
        hour = key.toInteger()
        minute = value.toInteger()
    }

    delegate.set(Calendar.HOUR_OF_DAY, hour)
    delegate.set(Calendar.MINUTE, minute)
    delegate.set(Calendar.SECOND, 0)
    delegate.time
}

println 2.days.ago.at(4:30)
