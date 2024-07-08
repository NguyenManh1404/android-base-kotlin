package com.example.aspenbase.ui.main
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentTransaction
//
//
//internal fun Fragment.replaceFragment(
//    containerId: Int,
//    fragment: Fragment,
//    transactionCallback: ((transaction: FragmentTransaction) -> Unit)? = null,
//    addToBackStack: Boolean = false,
//    tag: String? = null,
//) {
//null
//    val transaction = childFragmentManager.beginTransaction()
//
//    transactionCallback?.invoke(transaction)
//    transaction.replace(containerId, fragment, tag ?: fragment.javaClass.name)
//    if (addToBackStack) {
//        transaction.addToBackStack(tag ?: fragment.javaClass.name)
//    }
//    transaction.commit()
//}
//
//
//internal fun Fragment.addFragment(
//    containerId: Int,
//    fragment: Fragment,
//    transactionCallback: ((transaction: FragmentTransaction) -> Unit)? = null,
//    addToBackStack: Boolean = false,
//    tag: String? = null,
//
//    ) {
//    if (isAdded &&
//        childFragmentManager.findFragmentByTag(tag ?: fragment.javaClass.name) == null
//    ) {
//        val transaction = childFragmentManager.beginTransaction()
//        transactionCallback?.invoke(transaction)
//        transaction.add(containerId, fragment, tag ?: fragment.javaClass.name)
//        if (addToBackStack) {
//            transaction.addToBackStack(tag ?: fragment.javaClass.name)
//        }
//        transaction.commit()
//    }
//}
//
//
