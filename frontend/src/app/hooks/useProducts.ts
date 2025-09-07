"use client";
import { fetchProducts } from "@/lib/queries";
import { useQuery } from "@tanstack/react-query";
import { Product } from "../types/types";

export const useProducts = () => {
  return useQuery<Product[]>({
    queryKey: ["products"],
    queryFn: fetchProducts,
    staleTime: 5 * 60 * 1000,
    refetchOnWindowFocus: false,
  });
};
