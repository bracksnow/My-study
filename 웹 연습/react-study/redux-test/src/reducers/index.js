import { INCREASE, DECREASE } from '../actions'
import { combineReducers } from 'redux'

const initState = {
    value: 0,
}

const counter = (state = initState, action) => {
    switch(action.type) {
        case INCREASE:
            return Object.assign({}, state, {
                value: state.value + 1              
            })
        case DECREASE:
            return Object.assign({}, state, {
                value: state.value - 1              
            })
        default:
            return state

    }
}

const counterReducer = combineReducers({
    counter
})

export default counterReducer