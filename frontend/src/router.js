
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PayPayManager from "./components/listers/PayPayCards"
import PayPayDetail from "./components/listers/PayPayDetail"

import ManagementManagementManager from "./components/listers/ManagementManagementCards"
import ManagementManagementDetail from "./components/listers/ManagementManagementDetail"

import EnrollmentEnrollmentManager from "./components/listers/EnrollmentEnrollmentCards"
import EnrollmentEnrollmentDetail from "./components/listers/EnrollmentEnrollmentDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/pays/pays',
                name: 'PayPayManager',
                component: PayPayManager
            },
            {
                path: '/pays/pays/:id',
                name: 'PayPayDetail',
                component: PayPayDetail
            },

            {
                path: '/managements/managements',
                name: 'ManagementManagementManager',
                component: ManagementManagementManager
            },
            {
                path: '/managements/managements/:id',
                name: 'ManagementManagementDetail',
                component: ManagementManagementDetail
            },

            {
                path: '/enrollments/enrollments',
                name: 'EnrollmentEnrollmentManager',
                component: EnrollmentEnrollmentManager
            },
            {
                path: '/enrollments/enrollments/:id',
                name: 'EnrollmentEnrollmentDetail',
                component: EnrollmentEnrollmentDetail
            },





    ]
})
