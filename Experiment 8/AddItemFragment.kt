private fun showError(message: String) {
      Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
}

private fun isEntryValid(): Boolean {
    val name = binding.itemName.text.toString()
    val price = binding.itemPrice.text.toString()
    val count = binding.itemCount.text.toString()

    if (name.isBlank()) {
        showError("Item name cannot be empty")
        return false
    }

    if (price.isBlank() || price.toFloatOrNull() == null) {
        showError("Invalid price")
        return false
    }

    if (count.isBlank() || count.toIntOrNull() == null) {
        showError("Invalid count")
        return false
    }

    return true
}
