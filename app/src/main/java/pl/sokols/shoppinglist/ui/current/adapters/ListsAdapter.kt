package pl.sokols.shoppinglist.ui.current.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.sokols.shoppinglist.R
import pl.sokols.shoppinglist.data.entities.ShopList
import pl.sokols.shoppinglist.databinding.ShopListListitemBinding
import pl.sokols.shoppinglist.utils.OnItemClickListener
import pl.sokols.shoppinglist.utils.ShopListDiffCallback
import pl.sokols.shoppinglist.utils.Utils

class ListsAdapter : ListAdapter<ShopList, ListsAdapter.ListsViewHolder>(ShopListDiffCallback) {

    inner class ListsViewHolder(
        private val binding: ShopListListitemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(shopList: ShopList) {
            binding.shopList = shopList

            binding.shopListLayout.setOnClickListener {
                val bundle = bundleOf(Utils.SHOP_LIST_ID_KEY to shopList.id)
                it.findNavController()
                    .navigate(R.id.action_currentListsFragment_to_listDetailsFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListsViewHolder {
        return ListsViewHolder(
            ShopListListitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}