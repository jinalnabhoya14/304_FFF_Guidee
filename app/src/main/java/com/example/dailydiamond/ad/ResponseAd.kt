package com.example.dailydiamond.ad

import com.google.gson.annotations.SerializedName

data class ResponseAd(

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("AfterCallUrl")
	val afterCallUrl: String? = null,

	@field:SerializedName("AfterCallUrlStatus")
	val afterCallUrlStatus: String? = null,

	@field:SerializedName("AfterCallScreenStatus")
	val afterCallScreenStatus: String? = null,

	@field:SerializedName("AfterCallInterStatus")
	val afterCallInterStatus: String? = null,
)
