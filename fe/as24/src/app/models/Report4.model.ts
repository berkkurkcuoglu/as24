export interface Report4 {
  [monthYear: string]: [Listing, Listing, Listing, Listing, Listing];
}

export interface Listing {
  ranking: number;
  listingId: number;
  make: string;
  price: number;
  mileage: number;
  totalContacts: number;
}
