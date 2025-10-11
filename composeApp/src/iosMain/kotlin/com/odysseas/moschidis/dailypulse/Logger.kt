package com.odysseas.moschidis.dailypulse

import platform.Foundation.NSLog

actual fun printLog(tag: String, message: String) {
    NSLog("%s: %s", tag, message)
}