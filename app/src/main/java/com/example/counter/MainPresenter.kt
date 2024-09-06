package com.example.counter

class MainPresenter {

    private val model = CounterModel()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract) {
        this.contract = contract
        contract.showResult(model.count)

    }

    fun onIncrement(){
        model.increment()
        checkConditions()
        contract?.showResult(model.count)
    }

    fun onDecrement(){
        model.decrement()
        checkConditions()
        contract?.showResult(model.count)
    }

    private fun checkConditions() {
        if (model.count == 10) {
            contract?.showToast()
        } else if (model.count == 15) {
            contract?.changeTextGreen()
        }
    }

    fun detachContract() {
        contract = null
    }
}