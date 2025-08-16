


export interface ScamCategory{
  id:string;
  name:string;
}
export interface  CaseType{
  id:string;
  name: string;
  categoryId:string;
  story:string;
}

export interface SearchResultSummary{
  query:string;
  totalReports:number;
}

export interface ScamReport {
  id: string;
  country: string;
  bank_account_number: string;
  bank_name?: string;
  scammer_alias?: string;
  amount_lost?: number;
  phone_number?: string;
  scam_description?: string;
  evidence_urls: string[];
  created_at: string;
  status: 'ACTIVE' | 'DISPUTED' | 'REMOVED';
}


export const SCAM_CATEGORIES: ScamCategory[] = [
  { id: 'romance', name: 'Romance & Dating Scam' },
  { id: 'investment', name: 'Investment Scam' },
  { id: 'shopping', name: 'Online Shopping Scam' },
  { id: 'phishing', name: 'Phishing (Email, SMS, Call)' },
  { id: 'impersonation', name: 'Impersonation Scam' },
  { id: 'job', name: 'Job & Employment Scam' },
  { id: 'lottery', name: 'Lottery & Prize Scam' },
  { id: 'extortion', name: 'Threats & Extortion Scam' },
  { id: 'tech_support', name: 'Tech Support / Remote Access Scam' },
  { id: 'identity', name: 'Identity Theft' },
  { id: 'crypto', name: 'Cryptocurrency Scam' },
  { id: 'charity', name: 'Fake Charity / Donation Scam' },
  { id: 'Money Transfer', name: 'Fake Charity / Donation Scam' },
];

export const CASE_TYPES: CaseType[] = [
  // 💔 Romance
  {
    id: 'catfishing',
    name: 'Catfishing / Pig-Butchering Scam',
    categoryId: 'romance',
    story: 'Victim met someone on Facebook who promised marriage. After months of chatting, the scammer asked for money to pay for travel documents. Once the transfer was made, the scammer disappeared.'
  },
  {
    id: 'overseas_transfer_block',
    name: 'Overseas Money Transfer Scam',
    categoryId: 'romance',
    story: 'Victim was told their “partner” needed money urgently overseas. After transferring funds via remittance, the scammer blocked the victim on WhatsApp and social media.'
  },

  // 🎣 Phishing
  {
    id: 'gov_aid_phishing',
    name: 'Government Aid Phishing',
    categoryId: 'phishing',
    story: 'Victim received an SMS claiming to be from Bantuan Malaysia with a link to update bank info. The fake site stole their login details and emptied the account.'
  },
  {
    id: 'subscription_phishing',
    name: 'Subscription Renewal Scam',
    categoryId: 'phishing',
    story: 'Victim got an email saying Netflix account would be suspended. Clicking the link led to a fake payment page where credit card details were stolen.'
  },

  // 💸 Investment
  {
    id: 'crypto_tax',
    name: 'Crypto Scam with Fake Profit + Tax Demand',
    categoryId: 'investment',
    story: 'Victim joined a Telegram group promoting crypto investment. Their “profits” grew quickly, but when they tried to withdraw, they were told to pay 30% “tax.” After payment, the platform vanished.'
  },
  {
    id: 'forex_quick_profit',
    name: 'Forex Quick Profit Scam',
    categoryId: 'investment',
    story: 'Victim joined a WhatsApp group offering daily forex tips. They were asked to invest RM5,000 for guaranteed profit. After sending the money, the admin blocked them.'
  },

  // 🚨 Impersonation
  {
    id: 'macau_scam',
    name: 'Macau Scam (Authority Impersonation)',
    categoryId: 'impersonation',
    story: 'Victim received a call from someone claiming to be Bank Negara. They were told their account was linked to crime and must transfer money to a “safe account.” Once transferred, the money was gone.'
  },

  // 🧑‍💼 Job Scams
  {
    id: 'fake_job_portal',
    name: 'Fake Job Portal Scam',
    categoryId: 'job',
    story: 'Victim applied for a data entry job online. They were asked to pay a “registration fee” to unlock tasks. After paying, the portal was shut down.'
  },

  // 🛍️ Shopping
  {
    id: 'non_delivery',
    name: 'Online Purchase Non-Delivery',
    categoryId: 'shopping',
    story: 'Victim bought a smartphone from a Facebook seller. Payment was made via bank transfer, but the seller blocked the victim and never shipped the phone.'
  }
];
