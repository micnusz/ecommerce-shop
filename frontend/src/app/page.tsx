"use server";

import { ProductsGrid } from "@/components/ProductsGrid";
import { fetchProducts } from "@/lib/queries";

export default async function Home() {
  const products = await fetchProducts();
  return (
    <div>
      <ProductsGrid serverProducts={products} />
    </div>
  );
}
