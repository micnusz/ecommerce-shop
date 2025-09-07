"use client";
import { Product } from "@/app/types/types";
import { Card, CardContent } from "@/components/ui/card";
import { Button } from "./ui/button";
import Image from "next/image";
import { Badge } from "./ui/badge";
import { RatingStars } from "./RatingStars";

type ProductCardProps = {
  product: Product;
};

export const ProductCard = ({ product }: ProductCardProps) => {
  return (
    <li>
      <Card className="min-w-[200px] max-w-xs flex flex-col rounded-xl shadow-lg overflow-hidden relative transition duration-300 hover:scale-103">
        <div className="absolute top-2 right-2 transition duration-150 hover:scale-105">
          <Badge variant="destructive">{product.category}</Badge>
        </div>
        <CardContent className="px-4 py-2 flex flex-col gap-y-6">
          <div className="relative h-60 w-full overflow-hidden">
            <Image
              src={product.images[0]}
              alt={product.title}
              fill
              className="object-cover"
              sizes="(max-width: 640px) 100vw, 25vw"
            />
          </div>
          <div className="flex flex-col gap-y-4">
            <div>
              <h3 className="text-sm">{product.brand}</h3>
              <h3 className="text-md font-semibold">{product.title}</h3>
            </div>
            <div>
              <span>
                <RatingStars rating={product.rating} />
              </span>
            </div>
          </div>
          <div>
            <Button className="rounded-2xl" variant="destructive">
              Add to cart
            </Button>
          </div>
        </CardContent>
      </Card>
    </li>
  );
};
