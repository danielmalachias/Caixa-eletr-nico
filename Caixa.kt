//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.system.exitProcess

var nome = ""
var saldo = 100.5 // Float

fun main() {
    inicio()
}

fun inicio() {
    println("Digite seu nome:")
    nome = readln()
    println("Olá $nome, é um prazer ter você por aqui!")
    println("Informe um número para continuar:\n 1: Ver saldo\n 2: Ver extrato\n 3: Fazer saque\n 4: Fazer depósito\n 5: Fazer transferência\n 6: Sair")
    val escolha = readLine()?.toIntOrNull()

    when (escolha) {
        1 -> verSaldo()
        2 -> extrato()
        3 -> fazerSaque()
        4 -> fazerDeposito()
        5 -> transferencia()
        6 -> sair()
        else -> erro()

    }
}

fun verSaldo() {println("Por favor, informe sua senha: ")
    val senha = readlnOrNull()
    val loginefetuado = validarsenha(senha.toString())
    if (loginefetuado) {
        println("Acesso concedido")
    } else {
        println("Acesso negado")
        fazerSaque()
        return
    }
    println("Seu saldo atual é: $saldo")
    inicio()
}

fun fazerDeposito() {
    println("Por favor, informe sua senha: ")
    val senha = readlnOrNull()
    val loginefetuado = validarsenha(senha.toString())
    if (loginefetuado) {
        println("Acesso concedido")
    } else {
        println("Acesso negado")
        fazerSaque()
        return
    }
    print("Qual o valor para depósito? ")
    var deposito: Float?
    deposito = readln().toFloatOrNull()

    if (deposito == null || deposito <= 0) {
        println("Por favor, informe um número válido e maior que zero.")
        fazerDeposito()
        return
    } else {
        saldo += deposito
        verSaldo()
    }
}

    fun fazerSaque() {
        println("Por favor, informe sua senha: ")
        val senha = readlnOrNull()
        val loginefetuado = validarsenha(senha.toString())
        if (loginefetuado) {
            println("Acesso concedido")
        } else {
            println("Acesso negado")
            fazerSaque()
            return
        }
        print("Qual o valor para saque? ")
        var saque: Float?
        saque = readln().toFloatOrNull()

        if (saque == null || saque <= 0) {
            println("Por favor, informe um número válido e maior que zero.")
            fazerSaque()
            return
        } else if (saldo < saque) {
            println("Operação não autorizada.")
        } else {
            saldo -= saque
            verSaldo()
        }
    }

    fun erro() {
        println("Por favor, informe um número entre 1 a 6.")
        inicio()
    }

    fun sair() {
        print("Você deseja sair? (S/N) ")
        val confirma = readlnOrNull().orEmpty().uppercase()

        when (confirma) {
            "S" -> {
                println("$nome, foi um prazer ter você por aqui.")
                exitProcess(0)
            }
            "N" -> inicio()
            else -> sair()
        }
    }

    fun extrato() {
        println(" -304.15 Outback\n -402.01 Carrefour\n -12.00 Oxxo")
        verSaldo()
    }

    fun transferencia() {
        println("Por favor, informe sua senha: ")
        val senha = readlnOrNull()
        val loginefetuado = validarsenha(senha.toString())
        if (loginefetuado) {
            println("Acesso concedido")
        } else {
            println("Acesso negado")
            fazerSaque()
            return
        }
        println("Digite a conta destino: ")
        var destino: Int? = null

        while (destino == null) {
            print("Digite um número inteiro: ")
            val input = readLine()
            destino = input?.toIntOrNull()

            if (destino == null) {
                println("Entrada inválida! Tente novamente.")
            }
        }
        println("Digite o valor da transferência: ")
        var tranfer: Double
        var transfer = readln().toDouble()
        if (saldo < transfer) {
            println("Operação não autorizada!")
        }
        saldo = saldo - transfer
        println("Transferência concluída")
        verSaldo()


    }

    fun validarsenha(senha: String): Boolean {
        val senhacorreta = "3589"
        return senha == senhacorreta
    }



