package com.example.foodapprecyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapprecyclerview.Food
import com.example.foodapprecyclerview.adapter.FoodAdapter
import com.example.foodapprecyclerview.api.ApiUtils
import com.example.foodapprecyclerview.databinding.FragmentHomeBinding
import com.example.foodapprecyclerview.model.FoodResponse
import com.example.foodapprecyclerview.model.FoodResponseItem
import com.example.foodapprecyclerview.model.Hint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private val api=ApiUtils.getFoodApi()
    private val adapter= FoodAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        getFoodData()

    }

    private fun getFoodData() {
        api.getAllFood().enqueue(object:Callback<Food>{
            override fun onResponse(
                call: Call<Food>,
                response: Response<Food>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        adapter.updateList(it)
                    }
                }
                else{
                    Toast.makeText(requireContext(),"Error",Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<Food>, t: Throwable) {
                Toast.makeText(requireContext(),t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }
        )

    }
    private fun setRecyclerView() {
        binding.rvFood.layoutManager = LinearLayoutManager(requireContext(), GridLayoutManager.VERTICAL,false)
        binding.rvFood.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    }


