// lib/queries.ts
import { Product, ProductResponse } from "@/app/types/types";
import axios from "./axios";

export const fetchProducts = async (): Promise<ProductResponse> => {
  const { data } = await axios.get<ProductResponse>("/products");
  return data;
};

export const fetchProductById = async (id: number): Promise<Product> => {
  const { data } = await axios.get(`/products/${id}`);
  return data;
};
