package com.svape.mrolympiacompose.core

sealed class ConnectionStatus {
    object Available: ConnectionStatus()
    object Unavailable: ConnectionStatus()
}