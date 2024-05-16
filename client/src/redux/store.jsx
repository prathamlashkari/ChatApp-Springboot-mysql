import { thunk } from "redux-thunk";
import { combineReducers, legacy_createStore, applyMiddleware } from "redux";

const rootReducer = combineReducers([]);


export const store = legacy_createStore(rootReducer , applyMiddleware(thunk));