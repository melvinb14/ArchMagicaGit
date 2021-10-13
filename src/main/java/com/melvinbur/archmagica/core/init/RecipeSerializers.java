package com.melvinbur.archmagica.core.init;

import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.common.recipes.AlloyingRecipeSerializer;

import com.melvinbur.archmagica.common.recipes.AlloyingRecipe;


import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RecipeSerializers {
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = 
			DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ArchMagica.MOD_ID);
	
	public static final RegistryObject<AlloyingRecipeSerializer<AlloyingRecipe>> ALLOYING = RECIPE_SERIALIZERS.register("alloying", 
			() -> new AlloyingRecipeSerializer<>(AlloyingRecipe::new));


	
	
	
	public static <T extends IRecipe<?>> IRecipeType<T> registerRecipeType(String type) 
	{
		ResourceLocation recipeTypeId = new ResourceLocation(ArchMagica.MOD_ID, type);
		return Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new IRecipeType<T>() 
		{
			public String toString() 
			{
				return type;
			}
	    });
	}
}