"use client";
import { ProductResponse } from "@/app/types/types";
import { fetchProducts } from "@/lib/queries";
import { useQuery } from "@tanstack/react-query";
import { ProductCard } from "./ProductCard";

type Props = {
  serverProducts?: ProductResponse;
};

export const ProductsGrid = ({ serverProducts }: Props) => {
  const { data, isLoading, isError } = useQuery({
    queryKey: ["products"],
    queryFn: fetchProducts,
    initialData: serverProducts,
  });

  if (isLoading) return <p>Loading...</p>;
  if (isError) return <p>Error!</p>;
  return (
    <div className="px-4 py-4">
      <ul className="grid gap-4 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-6">
        {data?.products.map((product) => (
          <ProductCard product={product} key={product.id} />
        ))}
      </ul>
    </div>
  );
};
