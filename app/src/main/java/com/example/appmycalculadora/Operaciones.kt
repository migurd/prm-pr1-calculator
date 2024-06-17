package com.example.appmycalculadora

class Operaciones(var num1: Float, var num2: Float) {
    // var --> mutable
    public fun suma() : Float {
        return this.num1 + this.num2
    }
    public fun restar() : Float {
        return this.num1 - this.num2
    }
    public fun multiplicar() : Float {
        return this.num1 * this.num2
    }
    public fun dividir() : Float {
        return this.num1 / this.num2
    }
}