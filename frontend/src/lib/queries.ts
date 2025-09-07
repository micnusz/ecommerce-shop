// lib/queries.ts
import axios from "./axios";

export const fetchProducts = async () => {
  const { data } = await axios.get("/products");
  return data;
};

export const fetchProductById = async (id: number) => {
  const { data } = await axios.get(`/products/${id}`);
  return data;
};

export const fetchCategories = async () => {
  const { data } = await axios.get("/categories");
  return data;
};

export const fetchCategoryById = async (id: number) => {
  const { data } = await axios.get(`/categories/${id}`);
  return data;
};

export const fetchCategoryBySlug = async (slug: string) => {
  const { data } = await axios.get(`/categories/slug/${slug}`);
  return data;
};
