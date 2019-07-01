package com.faz.stormtroopers.common.extension

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.faz.stormtroopers.common.util.RecyclerItemClickListener

@JvmOverloads
fun RecyclerView.affectOnItemClicks(onClick: ((position: Int, view: View) -> Unit)? = null, onLongClick: ((position: Int, view: View) -> Unit)? = null) {
    this.addOnChildAttachStateChangeListener(RecyclerItemClickListener(this, onClick, onLongClick))
}