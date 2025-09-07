"use client";
import { Product } from "@/app/types/types";
import { fetchProducts } from "@/lib/queries";
import { useQuery } from "@tanstack/react-query";

type Props = {
  serverProducts?: Product[];
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
    <ul>
      {data?.map((product) => (
        <li key={product.id}>{product.title}</li>
      ))}
    </ul>
  );
};
