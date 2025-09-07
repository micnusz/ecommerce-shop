export type Product = {
  id: number;
  title: string;
  price: number;
  description: string;
  images: Images[];
  category: Category;
};

export type Images = {
  image: string;
};

export type Category = {
  id: number;
  name: string;
  image: string;
  slug: string;
};
