// lib/queries.ts
import { Category, Product } from "@/app/types/types";
import axios from "./axios";

export const fetchProducts = async (): Promise<Product[]> => {
  const { data } = await axios.get("/products");
  return data;
};

export const fetchProductById = async (id: number): Promise<Product> => {
  const { data } = await axios.get(`/products/${id}`);
  return data;
};

export const fetchCategories = async (): Promise<Category[]> => {
  const { data } = await axios.get("/categories");
  return data;
};

export const fetchCategoryById = async (id: number): Promise<Category> => {
  const { data } = await axios.get(`/categories/${id}`);
  return data;
};

export const fetchCategoryBySlug = async (slug: string): Promise<Category> => {
  const { data } = await axios.get(`/categories/slug/${slug}`);
  return data;
};
