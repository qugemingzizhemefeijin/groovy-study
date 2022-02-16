package cg.zz.chapter01

// 安全导航符

def foo(str) {
    //if (str != null) { str.reverse() }
    str?.reverse();
}

println foo("evil")
println foo(null)
